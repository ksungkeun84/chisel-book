package ch5
import chisel3._
import chisel3.util._

class Arbiter2 extends Module {
  val io = IO(new Bundle{
    val r = Input(UInt(2.W))
    val g = Output(UInt(2.W))
  })

  io.g := "b00".U
  switch(io.r) {
    is ("b01".U) { io.g := "b01".U }
    is ("b10".U) { io.g := "b10".U }
    is ("b11".U) { io.g := "b01".U }
  }
}

class Arbiter4 extends Module {
  val io = IO(new Bundle{
    val r = Input(UInt(4.W))
    val g = Output(UInt(4.W))
  })


  val r = VecInit(io.r.asBools)       // request
  val nr = r.length                   // number of requests
  val g = VecInit.fill(nr)(false.B)   // granted
  val ng = VecInit.fill(nr)(false.B)  // 1: has not granted

  // For the LSB 
  g(0) := r(0)
  ng(0) := !g(0)

  // The rest of bits
  for (i <- 1 until nr) {
    g(i) := r(i) && ng(i-1)
    ng(i):= !g(i) && ng(i-1)
  }

  io.g := g.asUInt

}

// MSB is highly prior than LSB
class Arbiter4R extends Module {
  val io = IO(new Bundle{
    val r = Input(UInt(4.W))
    val g = Output(UInt(4.W))
  })


  val r = VecInit(io.r.asBools)       // request
  val nr = r.length                   // number of requests
  val g = VecInit.fill(nr)(false.B)   // granted
  val ng = VecInit.fill(nr)(false.B)  // 1: has not granted

  // For the MSB
  g(nr-1) := r(nr-1)
  ng(nr-1) := !g(nr-1)

  // The rest of bits
  for (i <- nr - 2 to 0 by -1) {
    g(i) := r(i) && ng(i+1)
    ng(i):= !g(i) && ng(i+1)
  }

  io.g := g.asUInt

}
