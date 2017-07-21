module.exports = {
    entry: './app/app.js',
    output: {
        path: __dirname,
        filename: './public/bundle.js'
    },

    module: {
        loaders: [
            {
                loader: 'babel-loader',
                query: {
                    presets: ['react', 'es2015', 'stage-2']
                },
                test: /\.jsx?$/,
                exclude: /node_modules/,

            }
        ]
    }


};