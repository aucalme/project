const express = require('express');
const multer = require('multer');
const path = require('path');
const app = express();
const port = 3000;

let storage = multer.diskStorage({
  destination: function(req, file, cb) {
    cb(null, path.resolve(__dirname, '../uploads'));
  },
  filename: function(req, file, cb) {
    cb(null, Date.now() + path.extname(file.originalname));
  }
});

let upload = multer({ storage });

app.get('/', function(req, res) {
  res.sendFile(path.resolve(__dirname, '../index.html'));
});

app.post('/upload', upload.single('file'), function(req, res) {
  res.json({
    result: 'success'
  });
});

app.listen(port);
