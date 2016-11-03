package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) { case (block, move) => move match {
        case Left => block.left
        case Right => block.right
        case Up => block.up
        case Down => block.down
      }
    }
  }

  trait Level1 extends SolutionChecker {
      /* terrain for level 1*/

    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  
  test("from in Solver") {
    new Level1 {
      val b = startBlock
      val n = from(Stream((startBlock,List())), Set())
      assert((n take 3).toList == List((Block(Pos(1,2),Pos(1,3)),List(Right)), (Block(Pos(2,1),Pos(3,1)),List(Down)), (Block(Pos(1,4),Pos(1,4)),List(Right, Right)))
)
    }
  }
  
  test("pathsFromStart in Solver") {
    new Level1 {
      val b = startBlock
      val n = pathsFromStart
      assert((n take 3).toList == List((Block(Pos(1,2),Pos(1,3)),List(Right)), (Block(Pos(2,1),Pos(3,1)),List(Down)), (Block(Pos(1,4),Pos(1,4)),List(Right, Right)))
)
    }
  }
  
   test("pathsToGoal in Solver") {
    new Level1 {
      val b = startBlock
      val n = pathsToGoal
      assert((n take 10).toList == List((Block(Pos(4,7),Pos(4,7)),List(Down, Right, Right, Right, Down, Right, Right)), (Block(Pos(4,7),Pos(4,7)),List(Right, Down, Down, Right, Right, Down, Right)), (Block(Pos(4,7),Pos(4,7)),List(Right, Down, Right, Right, Down, Down, Right)))
)
    }
  }

   test("solution in Solver") {
    new Level1 {
      val b = startBlock
      val n = solution
      println(n)
    }
  }
   
    test("Pos in GameDef") {
    new Level1 {
      val p = new Pos(2,3)
      assert(p.x == 2)
    }
  }
    
    test("terrainFunction in StringParserTerrain") {
    new Level1 {
      val t =  Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', '-'))
      val p1 = new Pos(1,1) // valid
      val p2 = new Pos(1,2)   // not on grid
      val p3 = new Pos(2,1)   // on grid, but not valid
      assert(terrainFunction(t)(p1))
      assert(!terrainFunction(t)(p2))
      assert(!terrainFunction(t)(p3))
    }
  }
    
        test("isStanding in GameDef") {
    new Level1 {
      val b1 = new Block(new Pos(1,2), new Pos(1,2)) // standing
      val b2 =  new Block(new Pos(1,1), new Pos(1,2)) // not standing
      assert(b1.isStanding)
       assert(!b2.isStanding)
    }
  }
        
            test("isLegal in GameDef") {
    new Level1 {
      val b1 = new Block(new Pos(1,2), new Pos(1,2)) // both Pos standing in terrain
      val b2 = new Block(new Pos(0,2), new Pos(0,3)) // on Pos off terrain
       val b3 = new Block(new Pos(2,2), new Pos(3,2)) // both Pos lying in terrain
      assert(b1.isLegal)
      assert(!b2.isLegal)
      assert(b3.isLegal)
    }
  }
            
             test("how to access Pos in Block?") {
    new Level1 {
      val b = new Block(new Pos(1,2), new Pos(1,3)) // both Pos standing in terrain
      assert(b.b1 == new Pos(1,2))
      assert(b.b2 == new Pos(1,3))
    }
  }
             
                         test("startBlock") {
    new Level1 {
      val b = startBlock // both Pos standing in terrain
      assert(b.b1 == new Pos(1,1))
      assert(b.b2 == new Pos(1,1))
    }
  }
                         
                                                 test("move right") {
    new Level1 {
      val b = startBlock 
      val t = new Block(new Pos(1,2), new Pos(1,3))
      assert(b.right == t)
    }
  }
                                                 
test("neighbors") {
    new Level1 {
      val b = startBlock
     val c = b.neighbors
     assert(c == List((Block(Pos(1,-1),Pos(1,0)),Left), (Block(Pos(1,2),Pos(1,3)),Right), (Block(Pos(-1,1),Pos(0,1)),Up), (Block(Pos(2,1),Pos(3,1)),Down))
)
     
    }
  } 



test("legalNeighbors") {
    new Level1 {
      val b = startBlock
     val c = b.legalNeighbors
     assert(c == List((Block(Pos(1,2),Pos(1,3)),Right), (Block(Pos(2,1),Pos(3,1)),Down)))
     
    }
  } 


test("neighborsWithHistoryList") {
    new Level1 {
      val b = startBlock
     val history = List()
     assert(neighborsWithHistoryList(b,history) == List((Block(Pos(1,2),Pos(1,3)),List(Right)), (Block(Pos(2,1),Pos(3,1)),List(Down))))
     
     
    }
  } 

test("neighborsWithHistory") {
    new Level1 {
      val b = startBlock
     val history = List()
     assert((neighborsWithHistory(b,history) apply 0) == (Block(Pos(1,2),Pos(1,3)),List(Right)))
    
     
    }
  } 

test("neighborsWithHistory level 1") {
    new Level1 {
      val b = Block(Pos(1,1),Pos(1,1))
     val history = List(Left,Up)
     val res = Set(
  (Block(Pos(1,2),Pos(1,3)), List(Right,Left,Up)),
  (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
)
     assert((neighborsWithHistory(b,history)).toSet == res)
    
     
    }
  }


test("newNeighborsOnly level 1") {
    new Level1 {
      val neighbors = Set(
    (Block(Pos(1,2),Pos(1,3)), List(Right,Left,Up)),
    (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
  ).toStream
     val explored = Set(Block(Pos(1,2),Pos(1,3)), Block(Pos(1,1),Pos(1,1)))
     val res = Set(
    (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
  ).toStream
     assert((newNeighborsOnly(neighbors,explored)) == res)
    
     
    }
  }






             
                          test("done in Solver") {
    new Level1 {
      val b1 = new Block(new Pos(4,7), new Pos(4,7)) 
      val b2 = new Block(new Pos(4,6), new Pos(4,6)) 
      assert(done(b1))
      assert(!done(b2))
    }
  }
                          
                            
  
  
	test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0,0)), "0,0")
      assert(terrain(Pos(1,1)), "1,1") // start
      assert(terrain(Pos(4,7)), "4,7") // goal
      assert(terrain(Pos(5,8)), "5,8")
      assert(!terrain(Pos(5,9)), "5,9")
      assert(terrain(Pos(4,9)), "4,9")
      assert(!terrain(Pos(6,8)), "6,8")
      assert(!terrain(Pos(4,11)), "4,11")
      assert(!terrain(Pos(-1,0)), "-1,0")
      assert(!terrain(Pos(0,-1)), "0,-1")
    }
  }

	test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1,1))
    }
  }


	test("optimal solution for level 1") {
    new Level1 {
      assert(solve(solution) == Block(goal, goal))
    }
  }


	test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }

}
