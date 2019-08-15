
// https://www.codewars.com/kata/pyramid-slide-down/

/*
   /3/
  \7\ 4 
 2 \4\ 6 
8 5 \9\ 3
*/

function longestSlideDown(pyramid){
 for (var stage = pyramid.length-1; stage > 0; stage--){
    for (var square = 0; square < pyramid[stage-1].length; square++){
      pyramid[stage-1][square] = pyramid[stage-1][square] + Math.max(pyramid[stage][square], pyramid[stage][square+1]);
    }
  }
  return pyramid[0][0];
}
  
