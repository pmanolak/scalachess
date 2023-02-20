package chess

import scala.language.implicitConversions
import Pos.*

class QueenTest extends ChessTest:

  "a queen" should {

    val queen = White - Queen

    // "move in any direction until the edge of the board" in {
    //   pieceMoves(queen, D4) must bePoss(
    //     D5,
    //     D6,
    //     D7,
    //     D8,
    //     D3,
    //     D2,
    //     D1,
    //     E4,
    //     F4,
    //     G4,
    //     H4,
    //     C4,
    //     B4,
    //     A4,
    //     C3,
    //     B2,
    //     A1,
    //     E5,
    //     F6,
    //     G7,
    //     H8,
    //     C5,
    //     B6,
    //     A7,
    //     E3,
    //     F2,
    //     G1
    //   )
    // }

    // "move 1 position in any direction, even from the edges" in {
    //   pieceMoves(queen, H8) must bePoss(
    //     H7,
    //     H6,
    //     H5,
    //     H4,
    //     H3,
    //     H2,
    //     H1,
    //     G7,
    //     F6,
    //     E5,
    //     D4,
    //     C3,
    //     B2,
    //     A1,
    //     G8,
    //     F8,
    //     E8,
    //     D8,
    //     C8,
    //     B8,
    //     A8
    //   )
    // }

    "not move to positions that are occupied by the same colour" in {
      val board = """
k B



N Q    P

PPPPPPPP
 NBQKBNR
"""
      board destsFrom C4 must bePoss(
        board,
        """
k B   x
  x  x
x x x
 xxx
NxQxxxxP
 xxx
PPPPPPPP
 NBQKBNR
"""
      )
    }

    "capture opponent pieces" in {
      val board = """
k B
     q
p

N QP   P

PPPPPPPP
 NBQKBNR
"""
      board destsFrom C4 must bePoss(
        board,
        """
k B
  x  x
x x x
 xxx
NxQP   P
 xxx
PPPPPPPP
 NBQKBNR
"""
      )
    }
  }
