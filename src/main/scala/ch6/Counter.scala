package ch6
import chisel3._

abstract class Counter(n: Int) extends Module {
  val io = IO(new Bundle{
    val cnt = Output(UInt(8.W))
    val tick = Output(Bool()) // 1: indicates counter wrapps around
  })
}

class WhenCounter(n: Int) extends Counter(n) {

  val N = (n - 1).U
  val cntReg = RegInit(0.U(8.W))
  val tick = cntReg === N

  when (tick) {
    cntReg := 0.U
  } .otherwise {
    cntReg := cntReg + 1.U
  }

  io.cnt := cntReg
  io.tick:= tick
}

class MuxCounter(n: Int) extends Counter(n) {

  val N = (n - 1).U
  val cntReg = RegInit(0.U(8.W))
  val tick = cntReg === N

  cntReg := Mux(tick, 0.U, cntReg + 1.U)

  io.cnt := cntReg
  io.tick:= tick
}

class DownCounter(n: Int) extends Counter(n) {

  val N = (n - 1).U
  val cntReg = RegInit(N)
  val tick = cntReg === 0.U

  cntReg := Mux(tick, N, cntReg - 1.U)

  io.cnt := cntReg
  io.tick:= tick
}

class FunctionCounter(n: Int) extends Counter(n) {
  
  def genCounter(n: Int) = {
    val N = (n-1).U
    val cntReg = RegInit(0.U(8.W))
    val tick = cntReg === N
    cntReg := Mux(tick, 0.U, cntReg + 1.U)
    cntReg
  }

  val testCounter = genCounter(n-1)
  io.tick := testCounter === (n-1).U
  io.cnt := testCounter
}

class NerdCounter(n: Int) extends Counter(n) {

  val N = (n-2).S
  val cntReg = RegInit(-1.S(8.W))

  val tick = cntReg(7) === 1.U
  cntReg := Mux(tick, N, cntReg - 1.S)

  io.cnt := cntReg.asUInt
  io.tick:= tick

}

object Counter extends App {
  emitVerilog(new WhenCounter(10), Array("--target-dir", "generated"))
}
