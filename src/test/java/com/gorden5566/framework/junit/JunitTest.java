package com.gorden5566.framework.junit;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunListener;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gorden5566
 * @date 2019/1/24
 */
public class JunitTest {
    private static Logger logger = LoggerFactory.getLogger(JunitTest.class);

    public static void main(String[] args) {

        // 获取测试类
        String classPath = "com.gorden5566.framework.spring.SimpleAliasRegistryTests";
        Class testClass = loadTestClass(classPath);

        // 构建runner
        Runner runner = buildRunner(testClass);

        // 创建JUnitCore facade
        JUnitCore jUnitCore = new JUnitCore();

        // 添加Listener(非必须)
        jUnitCore.addListener(new TestRunListener());

        // 执行测试用例
        jUnitCore.run(runner);

        logger.info("test finished");
    }

    static class TestRunListener extends RunListener {
        @Override
        public void testRunStarted(Description description) throws Exception {
            System.out.println("run start: " + System.currentTimeMillis());
        }

        @Override
        public void testRunFinished(Result result) throws Exception {
            System.out.println("run finish: " + System.currentTimeMillis());
        }

    }

    /**
     * 根据类的路径加载类
     *
     * @param classPath
     * @return
     */
    private static Class loadTestClass(String classPath) {
        Class testClass = null;
        try {
            testClass = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            logger.error("class not found", e);
        }

        return testClass;
    }

    /**
     * 构建JUnit 4 runner
     *
     * @param testClass
     * @return
     */
    private static Runner buildRunner(Class testClass) {
        Runner runner = null;
        try {
            runner = new BlockJUnit4ClassRunner(testClass);
        } catch (InitializationError initializationError) {
            logger.error("runner initializationError", initializationError);
        }

        return runner;
    }


}
