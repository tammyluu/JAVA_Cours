use("demoRelation")

// db.user.insertOne({_id: "123", nom : "Michel", email : "michel@gmail.com", profil : {age: 30, hobbies: ["Peinture", "Sport"]}})

// db.user.find()
// db.user.insertOne({_id: "124", nom : "Paul", email : "paul@gmail.com", profil_Id : {age: 30, hobbies: ["Peinture", "Sport"]}})

// db.profil.insertOne({_id: "12346", age : 55, hobbies : ["Echec", "Football"]})
// db.profil.find()
// db.user.insertOne({_id: "124", nom : "Paul", email : "paul@gmail.com", profil_Id : ObjectId("12346")})
// db.profil.aggregate([{$lookup: {from : "user", localField: "_id", foreignField: "profil_Id", as : "user"}},
// {$match: {_id:  ObjectId('124')}}])