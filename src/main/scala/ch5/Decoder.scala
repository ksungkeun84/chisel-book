package ch5

import chisel3._

class Decoder2x4 extends Module {
  val io = IO(new Bundle{
    val in = Input(UInt(2.W))
    val out = Output(UInt(4.W))
  })

  io.out := 1.U << io.in
}
