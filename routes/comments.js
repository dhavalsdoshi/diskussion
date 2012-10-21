
/*
 * GET comments.
 */

exports.all = function(req, res){
	var mongojs = require('mongojs'); 
	var db = mongojs('localhost:27017/diskussion', ['comments']);
	var comments = db.collection('comments');
	  db.comments.find(function(err, docs) {
		  res.render('comments', { title: 'Comments' ,comments : docs});
	  });
};