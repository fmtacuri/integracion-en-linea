from flask import Flask, jsonify, request, abort

app = Flask(__name__)

data = [
    {
        "codigo": 12345,
        "identificacion": "1724585763",
        "nombres": "Freddy",
        "direccion": "Quito"
    },
    {
        "codigo": 54321,
        "identificacion": "2222222222",
        "nombres": "Mauricio",
        "direccion": "UIO"
    }
]


@app.route('/persona', methods=['GET'])
def returnPersonas():
    if (request.method == 'GET'):
        return jsonify(data)

@app.route('/persona/<int:codigo>', methods=['GET'])
def returnPersona(codigo):
    if (request.method == 'GET'):
        for persona in data:
            if(persona.get("codigo") == codigo):
                return jsonify(persona)
        abort(404)

@app.route('/persona', methods=['POST'])
def addPerson():
    if (request.headers.get('Content_Type')=='application/json'):
        person = request.json
        data.append(person)
        return "OK"
    else:
        abort(400, 'No valido')

if __name__ == '__main__':
    app.run(debug=True)