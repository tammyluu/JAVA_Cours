use("info");
// --a. Créer une nouvelle base de données nommée info et vérifiez qu'elle est sélectionnée.
// db.produits.insertOne({
//   nom: " MacBook Pro",
//   fabriquant :"Apple",
//   prix: 11435.99,
//   options: [
//     "Intel Core i5",
//     "Retina Display",
//     "Long life battery"
//   ]
// });

//--Créer une nouvelle collection nommée produits et y insérer le document suivant:
// db.produits.insertOne({
//   nom: " MacBook Air",
//   fabriquant :"Apple",
//   prix: 1259.73,
//   ultrabook : true,
//   options: [
//     "Intel Core i7",
//     "SSD",
//     "Long life battery"
//   ]
// });
// db.produits.find({}).count();

//-- Et enfin un dernier document:

// db.produits.insertOne({
//   nom: " Thinkpad X230",
//   fabriquant :"Lenevo",
//   prix: 114358.74,
//   ultrabook : true,
//   options: [
//     "Intel Core i5",
//     "SSD",
//     "Long life battery"
//   ]
// });

/* 2 - Effectuez les requêtes de lecture suivantes: -*/

// --A. - Récupérer tous les produits.
// db.produits.find({});

//--B. - Récupérer le premier produit

// db.produits.find({}).limit(1);

// C. - Trouver l’id du Thinkpad et faites la requête pour récupérer ce produit avec son id.
// db.produits.find({_id :ObjectId("65a69d363d2ab6bed3ff7c14")});


// D. - Récupérer les produits dont le prix est supérieur à 13723 DA
// db.produits.find({prix :{$gt : 13723}});


// E. - Récupérer le premier produit ayant le champ ultrabook à true
// db.produits.find({ultrabook : true}).limit(1);
// db.produits.findOne({ultrabook : true});


// F. - Récupérer le premier produit dont le nom contient Macbook
  // db.produits.findOne({ nom: { $regex: /Macbook/i } })




// G. - Récupérer les produits dont le nom commence par Macbook

// db.produits.find({ nom: { $regex : "^ Macbook", $options:"i"} });
// db.produits.find({ "nom": { $regex: /^ Macbook/i } })


// H. - Supprimer les deux produits dont le fabricant est Apple.
// db.produits.deleteMany({fabriquant: "Apple"});


// I. - Supprimer le Lenovo en utilisant uniquement son id.
// db.produits.deleteOne({_id: ObjectId("65a69d363d2ab6bed3ff7c14")});




