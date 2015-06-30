package com.rubin.demo;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {

    public RestApplication() {
        //加载 Resource
        register(Resources.class);

        //注册Json数据转换器
        register(JacksonJsonProvider.class);

        //Logging.
        register(LoggingFilter.class);
    }
}
