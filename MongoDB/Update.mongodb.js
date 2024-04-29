use("book");
 
// Update
 
// on modifie le statut et le nombre de page
// db.books.updateOne({_id: 45}, {$set: {status: "CANCELED", pageCount: 6000}});
 
// db.books.updateMany({_id: {$in: [55,75]}}, {$set: {status: "CANCELED"}});

// db.books.find({_id : {$in: [55,75]}});

// db.books.updateOne({_id: 45}, {$inc: {pageCount: 1000}});

// db.books.find({_id : 4});

// db.books.updateMany({_id: 45}, {$unset: {authors:[]}});

// db.books.updateOne({_id : 4},{$unset:{thumbnailUrl: []}});

// db.books.updateOne({_id : 4},{$rename:{status: "Position"}});

// - modifier si pages > 600  => prendre valeur 600
// db.books.updateOne({_id : 4},{$max: {"pageCount": 600}});

//-- // - modifier si pages < 120
// db.books.updateOne({_id : 4},{$min: {"pageCount": 120}});

// db.books.findOneAndDelete({_id : 4});

// db.books.deleteMany({});