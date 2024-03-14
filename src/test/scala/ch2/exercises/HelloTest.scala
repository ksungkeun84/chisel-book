package ch2.exercises
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class HelloTest extends AnyFlatSpec with ChiselScalatestTester {
  "Waveform" should "pass" in {
    test(new Hello).withAnnotations(Seq(WriteVcdAnnotation)) {
      dut => {
        for (a <- 0 until 8) {
          dut.io.sw.poke(a.U)
          dut.clock.step()
        }
      }
    }
  }
}
