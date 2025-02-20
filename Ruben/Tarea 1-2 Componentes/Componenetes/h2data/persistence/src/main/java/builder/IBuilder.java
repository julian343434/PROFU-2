package builder;

import config.DatabaseConfig;

public interface IBuilder<T, I> {
    public T withDatabaseConfig(DatabaseConfig databaseConfig);
    public I build();
}
