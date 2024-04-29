use("demoRelation")

// One To One
//db.user.insertOne({_id: "123", nom: "Michel", email: "michel@gmail.com", profil: { age: 30, hobbies: ["Peinture","Sport"]}})
//db.user.find()
// 65a7da8db8a15db7f28af7d2
//db.user.insertOne({_id: "124", nom: "Paul", email: "paul@gmail.com", profil_Id: ObjectId("65a7da8db8a15db7f28af7d2")})
//db.profil.insertOne({age: 55, hobbies: ["Echec","Football"]})
//db.profil.find()
//db.user.find()

/* db.profil.aggregate([
    {$lookup : {from: "user", localField: "_id", foreignField: "profil_Id", as: "user"}},
    {$match : {_id: ObjectId("65a7da8db8a15db7f28af7d2")}}])   */


/* db.user.aggregate([
    {$lookup : {from: "profil", localField: "profil_Id", foreignField: "_id", as: "profil"}},
    {$match : {_id: "124"}},{$project: {"profil_Id":0, "profil._id":0}}]) */

//db.utilisateur.insertOne({name:"Jean",age: 40});
//db.adresse.insertOne({street: "rue des fleurs", number : 46, city: "Croix", utilisateur_id: ObjectId("65a7e3e333cd374525af92b9") })
//db.utilisateur.find()
//db.adresse.find();

/* db.utilisateur.aggregate([
    {$lookup : {from: "adresse", localField: "_id" , foreignField: "utilisateur_id", as: "adresse"}}]) */
   
//  db.utilisateur.aggregate([
//     {$lookup : {from: "adresse", localField: "_id" , foreignField: "utilisateur_id", as: "adresse"}},
//     {$project: {"adresse._id":0, "adresse.utilisateur_id":0 }} ]) 

// One To Many : 
// 65a7eed6d0367cc19cdc5066
// 65a7eed6d0367cc19cdc5067
// 65a7efe2eb8dddcc06602c55
// db.books.insertMany([{name: "J'aime bien le distanciel"},{name:"Mais je prefere le presentiel"}])
// db.authors.insertOne({name:"Maximus", books: [ObjectId("65a7eed6d0367cc19cdc5066"), ObjectId("65a7eed6d0367cc19cdc5067")]})

// db.authors.aggregate([
//     {$lookup: {from: "books", localField: "books", foreignField : "_id", as: "books"}},
//     {$project : {"books._id":0}}
// ])