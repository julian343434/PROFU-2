package facthory;

import builder.FileBuilder;
import builder.FileRepository;
import config.DatabaseConfig;

public class DefaultFileRepository extends FileFactory{
    @Override
    public FileRepository createFileRepository() {
        return new FileBuilder()
                .withDatabaseConfig(DatabaseConfig.getInstance())
                .build();
    }
}
