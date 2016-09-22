package application

import org.apache.spark._
import org.warcbase.spark.rdd.RecordRDD._
import org.warcbase.spark.matchbox.RecordLoader

object WarcBaseExample {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Pi")
    val spark = new SparkContext(conf)

    val in = "/tmp/file.warc.gz"
    val r = RecordLoader.loadArchives(in, spark)
      .keepValidPages()
      .map(r => r.getUrl)
      .collect

    spark.stop()
  }
}
