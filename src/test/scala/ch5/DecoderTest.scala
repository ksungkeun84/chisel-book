package ch5

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class DecoderTest extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test(new Decoder2x4) {
      dut => {
        for(i <- 0 until 4) {
          dut.io.in.poke(i.U)
          dut.io.out.expect((1 << i).U)
        }
      }
    }
  }
}
