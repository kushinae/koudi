const { generateService } = require('@umijs/openapi');

generateService({
  schemaPath: 'http://127.0.0.1:5186/product/v3/api-docs',
  serversPath: './src/services',
  projectName: 'product',
});
