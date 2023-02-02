package chess

import scala.language.implicitConversions
import Pos.*
import bitboard.Bitboard.*
import chess.bitboard.Bitboard

class RookTest extends ChessTest:

  "a rook" should {

    val rook = White - Rook

    "move to any position along the same rank or file" in {
      pieceMoves(rook, E4) must bePoss(E5, E6, E7, E8, E3, E2, E1, F4, G4, H4, D4, C4, B4, A4)
    }

    "move to any position along the same rank or file, even when at the edges" in {
      pieceMoves(rook, H8) must bePoss(H7, H6, H5, H4, H3, H2, H1, G8, F8, E8, D8, C8, B8, A8)
    }

    "not move to positions that are occupied by the same colour" in {
      """
k B



N R    P

PPPPPPPP
 NBQKBNR
""" destsFrom C4 must bePoss(C3, C5, C6, C7, B4, D4, E4, F4, G4)
    }

    "capture opponent pieces" in {
      """
k
  b


n R   p

PPPPPPPP
 NBQKBNR
""" destsFrom C4 must bePoss(C3, C5, C6, C7, B4, A4, D4, E4, F4, G4)
    }
  }
