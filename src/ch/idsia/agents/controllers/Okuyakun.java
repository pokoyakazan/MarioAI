
/*
 * Copyright (c) 2009-2010, Sergey Karakovskiy and Julian Togelius
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Mario AI nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package ch.idsia.agents.controllers;

import ch.idsia.agents.Agent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.engine.sprites.Sprite;
import ch.idsia.benchmark.mario.environments.Environment;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Apr 25, 2009
 * Time: 12:27:07 AM
 * Package: ch.idsia.agents.controllers;
 */

public class Okuyakun extends BasicMarioAIAgent implements Agent
{
public Okuyakun()
{
    super("Okuyakun");
    reset();
}

public boolean[] getAction()
{
   if(getReceptiveFieldCellValue(marioEgoRow ,marioEgoCol + 3) != Sprite.KIND_NONE
		   || getEnemiesCellValue(marioEgoRow ,marioEgoCol + 3) != Sprite.KIND_NONE){
	   action[Mario.KEY_JUMP] = isMarioAbleToJump || !isMarioOnGround;//�E��=True or False
   }
   
   else if(getReceptiveFieldCellValue(marioEgoRow ,marioEgoCol + 1) != Sprite.KIND_NONE
		   || getEnemiesCellValue(marioEgoRow ,marioEgoCol + 1) != Sprite.KIND_NONE){
	   action[Mario.KEY_JUMP] = isMarioAbleToJump || !isMarioOnGround;//�E��=True or False
   }
	
	
    return action;
}

public void reset()
{
    action = new boolean[Environment.numberOfKeys];
    action[Mario.KEY_RIGHT] = true;
    action[Mario.KEY_SPEED] = true;
}
}