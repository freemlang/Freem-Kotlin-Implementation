package freem.partition.analyzer.task

internal interface AnalyzeTask {
    /**
     * @return success or failure
     */
    fun AnalyzeTaskExecutionField.run(): Boolean
}