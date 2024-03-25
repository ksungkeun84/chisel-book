package ch5
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class Arbiter2Test extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test (new Arbiter2) {
      dut => {
        dut.io.r.poke("b00".U); dut.io.g.expect("b00".U)
        dut.io.r.poke("b01".U); dut.io.g.expect("b01".U) 
        dut.io.r.poke("b10".U); dut.io.g.expect("b10".U)
        dut.io.r.poke("b11".U); dut.io.g.expect("b01".U)
      }
    }
  }
}

class Arbiter4Test extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test (new Arbiter4) {
      dut => {
        dut.io.r.poke("b0000".U); dut.io.g.expect("b0000".U)
        dut.io.r.poke("b0001".U); dut.io.g.expect("b0001".U)
        dut.io.r.poke("b0010".U); dut.io.g.expect("b0010".U)
        dut.io.r.poke("b0011".U); dut.io.g.expect("b0001".U)
        dut.io.r.poke("b0100".U); dut.io.g.expect("b0100".U)
        dut.io.r.poke("b0101".U); dut.io.g.expect("b0001".U)
        dut.io.r.poke("b0110".U); dut.io.g.expect("b0010".U)
        dut.io.r.poke("b0111".U); dut.io.g.expect("b0001".U)
        dut.io.r.poke("b1000".U); dut.io.g.expect("b1000".U)
        dut.io.r.poke("b1001".U); dut.io.g.expect("b0001".U)
        dut.io.r.poke("b1010".U); dut.io.g.expect("b0010".U)
        dut.io.r.poke("b1011".U); dut.io.g.expect("b0001".U)
        dut.io.r.poke("b1100".U); dut.io.g.expect("b0100".U)
        dut.io.r.poke("b1101".U); dut.io.g.expect("b0001".U)
        dut.io.r.poke("b1110".U); dut.io.g.expect("b0010".U)
        dut.io.r.poke("b1111".U); dut.io.g.expect("b0001".U)
      }
    }
  }
}

class Arbiter4$Test extends AnyFlatSpec with ChiselScalatestTester {
  "DUT" should "pass" in {
    test (new Arbiter4R) {
      dut => {
        dut.io.r.poke("b0000".U); dut.io.g.expect("b0000".U)
        dut.io.r.poke("b0001".U); dut.io.g.expect("b0001".U)
        dut.io.r.poke("b0010".U); dut.io.g.expect("b0010".U)
        dut.io.r.poke("b0011".U); dut.io.g.expect("b0010".U)
        dut.io.r.poke("b0100".U); dut.io.g.expect("b0100".U)
        dut.io.r.poke("b0101".U); dut.io.g.expect("b0100".U)
        dut.io.r.poke("b0110".U); dut.io.g.expect("b0100".U)
        dut.io.r.poke("b0111".U); dut.io.g.expect("b0100".U)
        dut.io.r.poke("b1000".U); dut.io.g.expect("b1000".U)
        dut.io.r.poke("b1001".U); dut.io.g.expect("b1000".U)
        dut.io.r.poke("b1010".U); dut.io.g.expect("b1000".U)
        dut.io.r.poke("b1011".U); dut.io.g.expect("b1000".U)
        dut.io.r.poke("b1100".U); dut.io.g.expect("b1000".U)
        dut.io.r.poke("b1101".U); dut.io.g.expect("b1000".U)
        dut.io.r.poke("b1110".U); dut.io.g.expect("b1000".U)
        dut.io.r.poke("b1111".U); dut.io.g.expect("b1000".U)
      }
    }
  }
}
