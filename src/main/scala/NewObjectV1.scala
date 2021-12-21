import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object NewObjectV1 extends App {

  val conf: SparkConf = new SparkConf().setMaster("local[1]").setAppName("TestJsonReader").set("spark.driver.host", "localhost")
  conf.set("spark.testing.memory", "2147480000")

  val spark:SparkSession  = SparkSession.builder().master("local[1]").config("spark.testing.memory", "2147480000")
    .appName("Stream2Learn")
    .getOrCreate()

  val rdd:RDD[Int] = spark.sparkContext.parallelize(List(1,2,3,4,5))
  val rddCollect:Array[Int] = rdd.collect()

  println("number of partitions:" + rdd.getNumPartitions)
  println("Action :first element :" +rdd.first())
  println("Action :rdd convert to Array[Int] :")
  rddCollect.foreach(println)


}
