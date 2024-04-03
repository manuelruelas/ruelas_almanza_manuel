

func areSimilar(a:[Int],b:[Int])->Bool{
        
        var differences = 0
        var diffIndices: [(Int, Int)] = []
        for i in 0..<a.count {
            if a[i] != b[i] {
                differences += 1
                diffIndices.append((a[i], b[i]))
            }
        }
        let withoutDifferences = differences == 0;
        if withoutDifferences || differences == 2 {
            
            return withoutDifferences || (differences == 2 && diffIndices[0] == (diffIndices[1].1, diffIndices[1].0))

        }
    
        
        return false
}


let a = [1,2,3];
let b = [1,2,3];
areSimilar(a: a,b: b);

let c = [1,2,3];
let d = [2,1,3];
areSimilar(a: c, b: d);

let e = [1,2,2];
let f = [2,1,3];
areSimilar(a: e, b: f);
