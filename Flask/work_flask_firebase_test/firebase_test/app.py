#// Import the functions you need from the SDKs you need
#import { initializeApp } from "firebase/app";
#import { getAnalytics } from "firebase/analytics";
#// TODO: Add SDKs for Firebase products that you want to use
#// https://firebase.google.com/docs/web/setup#available-libraries

#// Your web app's Firebase configuration
#// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyCG_HInjIdjwzxXoIsHEtQELE11inILjI4",
  authDomain: "todolist-4834a.firebaseapp.com",
  databaseURL: "https://todolist-4834a-default-rtdb.firebaseio.com",
  projectId: "todolist-4834a",
  storageBucket: "todolist-4834a.appspot.com",
  messagingSenderId: "906367548646",
  appId: "1:906367548646:web:0f47cebd090e911ed8cf27",
  measurementId: "G-CGG4N833BY"
};

#// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);




#list 2.9
from flask import Flask

app = Flask(__name__)

@app.route('/')
def firebaseTest():
    print(f'type : {type(value)}, value:{value}')
    return f'<h1> value : [{value}] </h1>'

if __name__ == '__main__':
    app.run()
