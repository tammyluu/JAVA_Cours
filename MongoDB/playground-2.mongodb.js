use("demo");
//db.products.insertOne({name:"Iphone", price :1250});
//db.products.find();
//db.createCollection("notes");
//db.notes.insertOne({matiere: "Java", date : new Date(2015/5/21), note : 15});

//CRUD
// insertions  creation:

//db.products.insertOne({nom:"Table", dimension : 15, poids : 500, prix :50});
//db.products.insertMany([{nom:"Table -base", dimension : 15, poids : 500, prix :50},
//{nom:"Chaise", dimension : 15, poids : 45, prix :15},
//{nom:"Armoire",hauteur: 250, couleurs :["blue", "rouge", "noire"], prix :250}]);
//db.products.find();

/*db.products.insertOne(
    {nom:"Voiture",
    marque : "Renault",
conducteurs : [{user : "alice", age : 18}, {user : "Tom", age : 25  
}]}
)
db.products.find();*/

// db.products.insertOne({_id : 2501, name : "Avion", carburant : "essence" });
db.products.find({_id : 2500});
