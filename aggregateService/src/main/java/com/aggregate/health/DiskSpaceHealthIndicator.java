package com.aggregate.health;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class DiskSpaceHealthIndicator extends AbstractHealthIndicator {

  private final FileStore fileStore;
  private final long thresholdBytes;

  @Autowired
  public DiskSpaceHealthIndicator(@Value("${health.filestore.path:${user.dir}}") String path,
      @Value("${health.filestore.threshold.bytes:10485760}") long thresholdBytes) throws IOException {
    fileStore = Files.getFileStore(Paths.get(path));
    this.thresholdBytes = thresholdBytes;
  }

  @Override
  protected void doHealthCheck(Health.Builder builder) throws Exception {
    long diskFreeInBytes = fileStore.getUnallocatedSpace();
    if (diskFreeInBytes >= thresholdBytes) {
      builder.up();
    } else {
      builder.down();
    }
    long totalSpaceInBytes = fileStore.getTotalSpace();
    builder.withDetail("disk.free", diskFreeInBytes);
    builder.withDetail("disk.total", totalSpaceInBytes);
  }
}
