
use("book");
//db.books.find();

//read:

//db.books.find({_id:45});

// --limitation 5
//db.books.find().limit(5);

// db.books.find({authors:{$size : 2}});

//-- nombre de page égal à 400 et plus gte = greater than equal
// db.books.find({pageCount : {$gte: 400}});

// --id ==15 , 45 et 120
// db.books.find({_id: {$in: [15,45,120]}});

// -- avec 2 auteurs, tri par titre et puis son id
//db.books.find({authors:{$size :2}}).sort({title : 1, _id : -1});

//-- avec 2 auteurs, tri par titre et puis son id mais on skip 10 premier
//db.books.find({authors:{$size :2}}).skip(10).sort({title : 1, _id : -1});

//-- avec 2 auteurs, tri par titre et puis son id mais on skip 10 premier, limite à 3
// db.books.find({authors:{$size :2}}).skip(10).sort({title : 1, _id : -1}).limit(3);

// id >25 et id<50
// db.books.find({ $and: [{_id: {$gt : 25}}, {_id: {$lt :50}}]});


//- afficher tous sauf et le tableau d'authors des livres avec id >45
// db.books.find({_id : {$gt: 45}}, {_id : 1, authors : 0} );


//- afficher l'id et le tableau d'authors des livres avec id >45
// db.books.find({_id : {$gt: 45}}, {_id : 1, authors : 1} );

//
// db.books.find({categories : {$in : ['Java', 'Web Development']}});

// db.books.find({categories : {$all : ['Java', 'Web Development']}});

// db.books.find({ $or: [{_id: 19 }, {_id: 55}]});

// --qui commence par  ^ ext ou Ext, options:"i" ça soit minicule ou manucule
// db.books.find({longDescription: {$regex : "^ext", $options:"i"}});

// --qui contient "Distributed"
// db.books.find({longDescription: {$regex : "Distributed", $options:"i"}});

// // -- qui termine  $ par perl Perl
// db.books.find({title: {$regex : "Perl$", $options:"i"}});

