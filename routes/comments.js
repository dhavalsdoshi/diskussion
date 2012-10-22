var mongojs = require('mongojs'); 
var db = mongojs('localhost:27017/diskussion', ['comments']);
var comments = db.collection('comments');


/*
 * GET all comments.
 */
exports.all = function(req, res){
	  db.comments.find(function(err, docs) {
		  res.render('comments', { title: 'Comments' ,comments : docs});
	  });
};

/*
 *  GET new comment page
 */
exports.enter = function(req, res){
	res.render('newComment', { title: 'Add a new comment' });
};


/*
 * POST comments.
 */

 exports.add = function(req,res){
	  db.comments.save({name:req.body.name,comment:req.body.comment});
	  res.send("Comment added");	  
 }