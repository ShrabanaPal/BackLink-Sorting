import { useState } from "react";

export default function CaptchaGate({ onSuccess }) {

  const [checked, setChecked] = useState(false);

  return (
    <div className="h-screen flex items-center justify-center">

      <div className="bg-slate-900 p-8 rounded-xl text-center">

        <h1 className="text-xl font-bold mb-4">
          Security Check
        </h1>

        <input
          type="checkbox"
          onChange={(e) => setChecked(e.target.checked)}
        />

        <p className="mt-2">I am not a robot</p>

        <button
          onClick={() => checked && onSuccess()}
          className="mt-4 bg-sky-500 px-5 py-2 rounded"
        >
          Continue
        </button>

      </div>

    </div>
  );
}