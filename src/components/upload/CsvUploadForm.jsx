import { useState } from "react";
import api from "../../api/axios";

export default function CSVUploadForm() {

  const [file, setFile] = useState(null);

  const upload = async () => {

    const formData = new FormData();
    formData.append("file", file);

    const res = await api.post("/upload", formData);

    alert(
      `Total: ${res.data.totalUploads}
Valid: ${res.data.validLinks}
Broken: ${res.data.brokenLinks}`
    );
  };

  return (
    <div className="bg-slate-900 p-6 rounded-xl">

      <input type="file" onChange={(e) => setFile(e.target.files[0])} />

      <button
        onClick={upload}
        className="bg-sky-500 px-5 py-2 mt-4 rounded"
      >
        Upload
      </button>

    </div>
  );
}