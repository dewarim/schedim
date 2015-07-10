dataSource {
    pooled = true

}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
 
    test {
        dataSource {
            driverClassName = "org.h2.Driver"
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            username = "sa"
            password = ""
        }
    }
    development {
        dataSource {
            driverClassName = "org.h2.Driver"
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            username = "sa"
            password = ""
        }
    }

    development_pg {
        dataSource {
            dbCreate = "update"
            pooling = true
            logSql = false
            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            url = "jdbc:postgresql://127.0.0.1:5432/schedim"
            username = 'goblin'
            password = 'goblin'
        }

    }

    production {
        dataSource {
            dbCreate = "update"
            pooling = true
            logSql = false

            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            url = "jdbc:postgresql://127.0.0.1:5432/schedim"
            username = 'goblin'
            password = 'goblin'
            autoReconnect = true
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=true
                validationQuery="SELECT 1"
            }
        }
    }
  
}
