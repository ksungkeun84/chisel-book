package ch5

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class EncoderTest extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test (new Encoder) {
      dut => {
        dut.io.in.poke(0.U)
        dut.io.out.expect(0.U)
        for (i <- 0 until 4) {
          dut.io.in.poke((1 << i).U)
          dut.io.out.expect(i)
        }
      }
    }
  }
}

class BigEncoderTest extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test (new BigEncoder) {
      dut => {
        dut.io.in.poke(0.U)
        dut.io.out.expect(0.U)
        for (i <- 0 until 16) {
          dut.io.in.poke((1 << i).U)
          println(s"case$i: ${1 << i} > ${dut.io.out.peekInt()}")
          dut.io.out.expect(i.U)
        }
      }
    }
  }
}
