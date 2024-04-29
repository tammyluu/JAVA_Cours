use("livre");
// • Liste de tous les livres (type « Book »).
// db.livres.find({ type: "Book" });


// • Liste des publications depuis 2011.
// db.livres.find({type: "Article", year:{$gte : 2011}});

// • Liste des livres depuis 2014.
db.livres.find({ type: "Book", year:{$gte: 2014}});

// • Liste des publications de l’auteur « Toru Ishida ».
// db.livres.find({ authors: "Toru Ishida"});

// • Liste de tous les éditeurs (type « publisher »), distincts.
// db.livres.distinct("publisher");

// • Liste de tous les auteurs distincts.
// db.livres.distinct("authors");