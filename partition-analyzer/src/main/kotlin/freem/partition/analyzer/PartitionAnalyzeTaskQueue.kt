package freem.partition.analyzer

import java.util.Queue

internal typealias PartitionAnalyzeTaskQueue = Queue<PartitionAnalyzeTaskField.() -> Unit>