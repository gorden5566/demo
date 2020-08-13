package com.gorden5566.demos.guice;

import com.google.inject.*;

/**
 * @author gorden5566
 * @date 2020/07/02
 */
public class MyInjector {
    private static Injector injector = Guice.createInjector(new MyModule());

    public static void main(String[] args) {
        HttpUtils httpUtils = injector.getInstance(HttpUtils.class);

        String result = httpUtils.doGet("https://www.baidu.com/");
        System.out.println(result);
    }

    private static class MyModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(HttpUtils.class).in(Singleton.class);
        }
    }
}
