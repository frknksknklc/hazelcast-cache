package com.example.demohazelcastcache;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelCastConfig {

    @Bean
    Config hazelcastConfig() {
        return new Config()
                .setInstanceName("haz-config-instance")
                .addMapConfig(
                        new MapConfig()
                        .setName("persons")
                                .setTimeToLiveSeconds(3000)
                                .setEvictionConfig(new EvictionConfig()
                                        .setSize(200)
                                        .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                                        .setEvictionPolicy(EvictionPolicy.LRU)


                    /*    .setEvictionPolicy(EvictionPolicy.LRU)
                        .setMaxSizeConfig(new MaxSizeConfig(100, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                        .setTimeToLiveSeconds(3600) */
                                ));
    }
}
