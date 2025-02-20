package builder;

import config.DatabaseConfig;

public class FileBuilder implements IBuilder<FileBuilder, FileRepository>{
    private DatabaseConfig databaseConfig;

    @Override
    public FileBuilder withDatabaseConfig(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
        return this;
    }

    @Override
    public FileRepository build() {
        if(databaseConfig == null){
            databaseConfig = DatabaseConfig.getInstance();
        }
        return new FileRepository(databaseConfig);
    }
}
