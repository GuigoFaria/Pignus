/*
 * VARIÁVEIS DE CORES DOS INTEGRANTES
 */

var anaBeatriz_1 = 'f7e4ad';
var anaBeatriz_2 = 'ffbb00';
var anaBeatriz_3 = 'b28302';

var biancaGomes_1 = 'c2f3fc';
var biancaGomes_2 = '6fd5e9';
var biancaGomes_3 = '2092a8';

var brunaPaz_1 = 'fc9aae';
var brunaPaz_2 = 'eb1d47';
var brunaPaz_3 = '960220';

var brunoCarvalho_1 = '9c9c9c';
var brunoCarvalho_2 = '424242';
var brunoCarvalho_3 = '121212';

var diegoBraga_1 = 'a7fac6';
var diegoBraga_2 = '00ff5f';
var diegoBraga_3 = '016e2a';

var guilhermeRaulino_1 = 'c4a8f7';
var guilhermeRaulino_2 = '391f68';
var guilhermeRaulino_3 = '0c021f';

/* 
 * VARIÁVEIS DE CORES DA EMPRESA
 */

var pigRed_1 = 'eb1d47';
var pigRed_2 = '990820';
var pigRed_3 = '5C0315';

var pigBlue_1 = '';
var pigBlue_2 = '';
var pigBlue_3 = '';

/*
 * VARIÁVEIS DE ESTRUTURA DO MENU
 */

var menu_1 = '040505'
var menu_2 = '131314';
var background_1 = '373737';
var background_2 = 'e8e8e8'




var buttonElement = document.getElementById('add-to-app');
var buttonSubmit = document.getElementsByClassName('btn-form-dash')[1];
buttonSubmit.style.display = 'none';

var containerElement = document.getElementById('app');
var itens = document.getElementById('socorro');

var suppArrSoftwares = [];
var arrSoftwares = [];

var suppArrPersons = [];
var arrPersons = [];

var softwaresSelecionados = document.getElementById('select-softwares');
var pessoasSelecionadas = document.getElementById('select-persons');

function validaSelecoes() {
  for( var i = 0; i < softwaresSelecionados.length; i++ )  {
    if( softwaresSelecionados.options[i].selected == true ) {
      suppArrSoftwares.push(softwaresSelecionados[i]);
    }
  }
  arrSoftwares.push(suppArrSoftwares);

  for( var i = 0; i < pessoasSelecionadas.length; i++ )  {
    if( pessoasSelecionadas.options[i].selected == true ) {
      suppArrPersons.push(pessoasSelecionadas[i]);
    }
  }
  arrPersons.push(suppArrPersons);
}

buttonElement.onclick = function() {
  buttonSubmit.style.display = 'block';
  validaSelecoes();

  var divider = document.createElement('div');
  
  var nomeProjeto = document.createElement('h3');
  var clienteBeneficiado = document.createElement('p');
  var descricaoProjeto = document.createElement('p');
  var listaSoftwares = document.createElement('p');
  var listaIntegrantes = document.createElement('p');

  var inputNomeProjeto = document.querySelector('input[name=nome-projeto]');
  var inputClienteBeneficiado = document.querySelector('input[name=cliente-beneficiado]');
  var inputDescricaoProjeto = document.querySelector('input[name=descricao-projeto]');

  var nomeProjetoText = document.createTextNode(inputNomeProjeto.value);
  nomeProjeto.appendChild(nomeProjetoText);
  divider.appendChild(nomeProjeto);

  var clienteBeneficiadoText = document.createTextNode('Cliente: ' + inputClienteBeneficiado.value);
  clienteBeneficiado.appendChild(clienteBeneficiadoText);
  divider.appendChild(clienteBeneficiado);

  var descricaoProjetoText = document.createTextNode('Descrição: ' + inputDescricaoProjeto.value);
  descricaoProjeto.appendChild(descricaoProjetoText);
  divider.appendChild(descricaoProjeto);

  var personsValues = [];
  var softwaresValues = [];
  for( var i = 0; i < suppArrPersons.length; i++ ) {
    personsValues.push(suppArrPersons[i].text);
  }
  var personsTexts = document.createTextNode('Colaboradores: ' + personsValues.join(', '));
  listaIntegrantes.appendChild(personsTexts);
  divider.appendChild(listaIntegrantes);

  for( var i = 0; i < suppArrSoftwares.length; i++ ) {
    softwaresValues.push(suppArrSoftwares[i].text);
  }
  var softwaresTexts = document.createTextNode('Softwares: ' + softwaresValues.join(', '));
  listaSoftwares.appendChild(softwaresTexts)
  divider.appendChild(listaSoftwares)

  containerElement.appendChild(divider);

  
  // Reseting Form
  suppArrPersons = [];
  suppArrSoftwares = [];
  inputNomeProjeto.value = '';
  inputClienteBeneficiado.value = '';
  inputDescricaoProjeto.value = '';
  for( var i = 0; i < pessoasSelecionadas.length; i++ )  {
    pessoasSelecionadas.options[i].selected = false;
  }
  for( var i = 0; i < softwaresSelecionados.length; i++ )  {
    softwaresSelecionados.options[i].selected = false;
  }
  
}