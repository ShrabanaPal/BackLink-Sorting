import UploadForm from "../components/upload/CsvUploadForm";

export default function UploadPage() {
  return (
    <div>
      <h1 className="text-3xl font-bold mb-6">
        Upload CSV File
      </h1>

      <UploadForm />
    </div>
  );
}