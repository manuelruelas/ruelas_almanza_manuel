func differentCharacters(word:String)->Int{
    var differentChars = Set(word);
      
    return differentChars.count;
}


differentCharacters(word: "aabbqwe");
differentCharacters(word: "aaaaaaaaaa")
differentCharacters(word: "aaaaaaaaaab")
