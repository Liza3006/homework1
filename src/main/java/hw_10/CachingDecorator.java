package hw_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CachingDecorator implements DataService {
  private DataService wrapped;
  private Map<String, String> cache = new HashMap<>();

  public CachingDecorator(DataService wrapped) {
    this.wrapped = wrapped;
  }

  @Override
  public Optional<String> findDataByKey(String key) {
    if (cache.containsKey(key)) {
      return Optional.of(cache.get(key));
    }
    Optional<String> result = wrapped.findDataByKey(key);
    result.ifPresent(data -> cache.put(key, data));
    return result;
  }

  @Override
  public void saveData(String key, String data) {
    cache.put(key, data);
    wrapped.saveData(key, data);
  }

  @Override
  public boolean deleteData(String key) {
    cache.remove(key);
    return wrapped.deleteData(key);
  }
}
