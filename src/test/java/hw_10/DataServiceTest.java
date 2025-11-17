package hw_10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataServiceTest {

  @Test
  void testCachingDecorator() {
    DataService service = new CachingDecorator(new SimpleDataService());
    service.saveData("key1", "value1");
    assertEquals("value1", service.findDataByKey("key1").get());
  }

  @Test
  void testLoggingDecorator() {
    DataService service = new LoggingDecorator(new SimpleDataService());
    service.saveData("key1", "value1");
    assertTrue(service.findDataByKey("key1").isPresent());
  }

  @Test
  void testMetricableDecorator() {
    DataService service = new MetricableDecorator(new SimpleDataService());
    service.saveData("key1", "value1");
    assertTrue(service.findDataByKey("key1").isPresent());
  }

  @Test
  void testValidationDecorator() {
    DataService service = new ValidationDecorator(new SimpleDataService());
    assertThrows(IllegalArgumentException.class, () -> service.saveData("", "value"));
  }
}
