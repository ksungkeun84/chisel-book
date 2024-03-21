package ch5
import chisel3._
import chisel3.util._

class Encoder extends Module {
  val io = IO(new Bundle{
    val in = Input(UInt(4.W))
    val out = Output(UInt(2.W))
  })

  io.out := "b00".U
  switch (io.in) {
    is ("b0001".U) { io.out := "b00".U }
    is ("b0010".U) { io.out := "b01".U }
    is ("b0100".U) { io.out := "b10".U }
    is ("b1000".U) { io.out := "b11".U }

  }
}

class BigEncoder extends Module {
  val io = IO(new Bundle{
    val in = Input(UInt(16.W))
    val out = Output(UInt(4.W))
  })

  val v = Wire(Vec(16, UInt(4.W)))
  v(0) := 0.U
  for (i <- 1 until 16) {
    v(i) := Mux(io.in(i), i.U, 0.U) | v(i - 1)
  }
  io.out := v(15)
}
