class GwtCompile extends JavaExec {

    @InputFiles classpath

    @TaskAction
    public void doTweak(){
        setClasspath();
        setMain("com.google.gwt.dev.Compiler")
        setMaxHeapSize("512M")
        args(
                'com.magicfinance.MagicFinance', // Your GWT module
                '-war', buildDir,
                '-logLevel', 'INFO',
                '-localWorkers', '2',
                '-compileReport',
                '-extra', extraDir,
                '-draftCompile'
        )
        setJvmArgs(getJvmArgs()); // ...and for 'jvmArgs')
        javaExecHandleBuilder.execute();
    }
}