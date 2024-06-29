// Arrow function for generating keys
const generateKeys = () => {
    const getValue = id => parseInt(document.getElementById(id).value);
    const prime = getValue('prime');
    const base = getValue('base');
    const privateKeyA = getValue('privateKeyA');
    const privateKeyB = getValue('privateKeyB');

    const modExp = (base, exponent, mod) => Math.pow(base, exponent) % mod;

    const publicKeyA = modExp(base, privateKeyA, prime);
    const publicKeyB = modExp(base, privateKeyB, prime);

    const sharedSecretA = modExp(publicKeyB, privateKeyA, prime);
    const sharedSecretB = modExp(publicKeyA, privateKeyB, prime);

    document.getElementById('output').innerHTML = `
        <p>Alice's public key: ${publicKeyA}</p>
        <p>Bob's public key: ${publicKeyB}</p>
        <p>Shared secret for Alice: ${sharedSecretA}</p>
        <p>Shared secret for Bob: ${sharedSecretB}</p>
    `;
};
document.getElementById('generateKeys').addEventListener('click', generateKeys);