package ch5
import chisel3._

class Comparator extends Module {
  val io = IO(new Bundle{
    val a = Input(UInt(4.W))
    val b = Input(UInt(4.W))
    val equ = Output(Bool())
    val gt = Output(Bool())
  })

  io.equ := io.a === io.b
  io.gt := io.a > io.b
  //val equ = io.a === io.b
  //val gt = io.a > io.b
  //io.equ := equ
  //io.gt := gt
}
