README: RUN JAVA PROGRAM from Lox.java & copy+paste the provided inputs

# Quick Test
- source + source's catchment flows into downstream's catchment
- INPUT: 
`20 + [5,5,5,5,5] > [2,2,3,3,0]`

# Canberra system
- googong > queanbeyan; (queanbeyan + upper_molongolo + jerrambarra) > central_molongolo >  lower_molongolo
- INPUT: 
`(([2,2,2,2,2] > [1,2,1,1,1]) + [0,0,0,0,0] + [1,1,2,1,3]) > [2,3,4,5,1] > [2,6,5,3,1]`

# Murray-Darling
- (Moonie + Macintyre + Gwydir + Namoi + Castlereagh + Macquarie) > (Barwon + Baloone + Culgao) + (Murrumbidgee + Murray) > Darling
- INPUT: 
`([2,3,3,4,5] + [1,1,2,3,6] + [2,6,7,6,4] + [0,0,1,1,0] + [0,0,0,0,0] + [0,0,0,1,0]) > ([2,2,2,3,5] + [0,0,0,1,1] + [0,0,0,1,0]) + ([0,0,0,0,1] + [0,0,1,1,1]) > [1,2,2,3,1]`
