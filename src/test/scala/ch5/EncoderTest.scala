package ch5

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class Encoder4x2Test extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test (new Encoder4x2) {
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

class Encoder16x4Test extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test (new Encoder16x4) {
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

class PriorityEncoder4x2Test extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test(new PriorityEncoder4x2) {
      dut => {
        dut.io.in.poke("b0001".U); dut.io.out.expect("b00".U)
        dut.io.in.poke("b0010".U); dut.io.out.expect("b01".U)
        dut.io.in.poke("b0011".U); dut.io.out.expect("b01".U)
        dut.io.in.poke("b0100".U); dut.io.out.expect("b10".U)
        dut.io.in.poke("b0101".U); dut.io.out.expect("b10".U)
        dut.io.in.poke("b0110".U); dut.io.out.expect("b10".U)
        dut.io.in.poke("b0111".U); dut.io.out.expect("b10".U)
        dut.io.in.poke("b1000".U); dut.io.out.expect("b11".U)
        dut.io.in.poke("b1001".U); dut.io.out.expect("b11".U)
        dut.io.in.poke("b1010".U); dut.io.out.expect("b11".U)
        dut.io.in.poke("b1011".U); dut.io.out.expect("b11".U)
        dut.io.in.poke("b1100".U); dut.io.out.expect("b11".U)
        dut.io.in.poke("b1101".U); dut.io.out.expect("b11".U)
        dut.io.in.poke("b1110".U); dut.io.out.expect("b11".U)
        dut.io.in.poke("b1111".U); dut.io.out.expect("b11".U)
      }
    }
  }
}
