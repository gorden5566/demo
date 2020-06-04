package com.gorden5566.demos.jcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gorden5566
 * @date 2020/06/05
 */
public class Args {
    @Parameter(required = false)
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
    private Integer verbose = 1;

    @Parameter(names = "-groups", description = "Comma-separated list of group names to be run")
    private String groups;

    @Parameter(names = "-debug", description = "是否打开调试模式")
    private boolean debug = false;

    public static void main(String[] args) {
        Args arg = new Args();
        String[] argv = { "-log", "2", "-groups", "unit" };
        JCommander jCommander = JCommander.newBuilder()
            .addObject(arg)
            .programName("java -jar Args.jar")
            .build();
        jCommander.usage();

        jCommander.parse(argv);
    }
}
